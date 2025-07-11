import { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';

function App() {
    const [todos, setTodos] = useState([]);
    const [text, setText] = useState('');

    // 전체 가져오기
    const fetchTodos = async () => {
        const res = await axios.get('http://localhost:5000/todos');
        setTodos(res.data);
    };

    useEffect(() => {
        fetchTodos();
    }, []);

    // 추가
    const addTodo = async () => {
        if (!text.trim()) return;
        await axios.post('http://localhost:5000/todos', { text });
        setText('');
        fetchTodos();
    };

    // 완료 토글
    const toggleTodo = async (id, completed) => {
        await axios.put(`http://localhost:5000/todos/${id}`, { completed: !completed });
        fetchTodos();
    };

    // 삭제
    const deleteTodo = async (id) => {
        await axios.delete(`http://localhost:5000/todos/${id}`);
        fetchTodos();
    };

    return (
        <div style={{ padding: '2rem' }}>
            <h1>📋 TODO LIST</h1>

            <input
                type="text"
                placeholder="할 일을 입력하세요"
                value={text}
                onChange={(e) => setText(e.target.value)}
            />
            <button onClick={addTodo}>추가</button>

            <ul>
                {todos.map((todo) => (
                    <li key={todo.id}>
                        <span
                            style={{
                                textDecoration: todo.completed ? 'line-through' : 'none',
                                marginRight: '1rem',
                                cursor: 'pointer'
                            }}
                            onClick={() => toggleTodo(todo.id, todo.completed)}
                        >
                            {todo.text}
                        </span>
                        <button onClick={() => deleteTodo(todo.id)}>삭제</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;