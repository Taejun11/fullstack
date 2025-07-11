import React, { useState, useEffect } from 'react'
import Header from './component/Header'
import "./App.css"
import TodoEditor from './component/TodoEditor'
import TodoList from './component/TodoList'

export default function App() {
    const [todo, setTodo] = useState([]);
    useEffect(() => {
        fetch('http://localhost:5000/todos')
            .then(res => res.json())
            .then(data => {
                const fixed = data.map(it => ({
                    ...it,
                    isDone: Boolean(it.isDone)
                }));
                console.log("서버 응답:", fixed);
                console.log("데이터 타입:", Array.isArray(fixed)); // true여야 함
                setTodo(fixed);
            })
            .catch((err) => {
                console.error("fetch 실패:", err);
            });
    }, []);
    const onCreate = (content) => {
        const createdDate = new Date().getTime();
        fetch('http://localhost:5000/todos', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ content, createdDate })
        })
            .then(res => res.json())
            .then(newTodo => {
                setTodo([newTodo, ...todo]);
            });
    };
    // 할 일의 id를 targetId로 받음
    const onUpdate = (targetId) => {
        const target = todo.find(it => it.id === targetId);
        if (!target) return;

        fetch(`http://localhost:5000/todos/${targetId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ isDone: !target.isDone })
        }).then(() => {
            setTodo(
                todo.map(it =>
                    it.id === targetId ? { ...it, isDone: !it.isDone } : it
                )
            );
        });
    };
    const onDelete = (targetId) => {
        fetch(`http://localhost:5000/todos/${targetId}`, {
            method: 'DELETE'
        }).then(() => {
            setTodo(todo.filter(it => it.id !== targetId));
        });
    };

    return (
        <div className='App'>
            <Header />
            <TodoEditor onCreate={onCreate} />
            <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
        </div>
    );
}
