import React, { useRef, useState } from 'react'
import UserList from './UserList';
import CreateUser from './CreateUser';

export default function App() {
    const [inputs, setInputs] = useState({
        username: '', email: ''
    });
    const { username, email } = inputs; //비구조화 할당(구조분해할당)

    const onChange = e => {
        const { name, value } = e.target;
        setInputs({
            ...inputs,
            [name]: value
        });
    };
    const onToggle = id => {
        setUsers(
            users.map(user => 
                user.id === id ? {...user, active : !user.active} : user
            )
        );
    };

    const [users, setUsers] = useState([
        {
            id: 1,
            username: 'velopert',
            email: 'public.velopert@gmail.com',
            active : true
        },
        {
            id: 2,
            username: 'tester',
            email: 'tester@example.com',
            active : false
        },
        {
            id: 3,
            username: 'liz',
            email: 'liz@example.com',
            active : false
        }
    ]);

    const nextId = useRef(4);
    const onCreate = () => {
        //구현
        const user = {
            id: nextId.current,
            username,
            email
        };
        setUsers([...users, user]);
        // setUsers(users.concat(user));

        setInputs({username: '', email: ''
        });
        nextId.current = + 1;
    }

    const onRemove = id => {
        setUsers(users.filter(user => user.id !== id));
    };

    return (
        <div>
            <CreateUser
                username={username}
                email={email}
                onChange={onChange}
                onCreate={onCreate}
            />
            <UserList users={users} onRemove={onRemove} onToggle={onToggle}/>
        </div>
    )
}
