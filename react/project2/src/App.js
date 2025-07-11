import React, { useRef, useState } from 'react'
import Header from './component/Header'
import "./App.css"
import TodoEditor from './component/TodoEditor'
import TodoList from './component/TodoList'

const mockTodo = [
    {
        id: 0,
        isDone: false,
        content: "React 공부하기",
        createdDate: new Date().getTime(),
    },
    {
        id: 1,
        isDone: false,
        content: "빨래 널기",
        createdDate: new Date().getTime(),
    },
    {
        id: 2,
        isDone: false,
        content: "노래 연습하기",
        createdDate: new Date().getTime(),
    },
];

export default function App() {
    const [todo, setTodo] = useState(mockTodo);
    const idRef = useRef(3);
    const onCreate = (content) => {
        const newItem = {
            id: idRef.current,
            content,
            isDone: false,
            createdDate: new Date().getTime()
        };
        setTodo([newItem, ...todo]);
        idRef.current += 1;
    };
    // 할 일의 id를 targetId로 받음
    const onUpdate = (targetId) => {
        setTodo(
            todo.map((it) => //현재 todo 배열 순회
                it.id === targetId ? { ...it, isDone: !it.isDone } : it
            )
        );
    };
    const onDelete = (targetId) => {
        // 실제 데이터가 삭제되는 것이 아님, 삭제 버튼 누른 요소 빼고 출력해주는 방식
        setTodo(todo.filter((it) => it.id !== targetId));
    };

    return (
        <div className='App'>
            <Header />
            <TodoEditor onCreate={onCreate} />
            <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete}/>
        </div>
    )
}
