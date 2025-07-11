import "./TodoList.css"
import TodoItem from "./TodoItem"
import { useState } from "react"

export default function TodoList({ todo, onUpdate, onDelete }) {
    const [search, setSearch] = useState("");
    const onChangeSearch = (e) => {
        setSearch(e.target.value);
    }
    const getSearchResult = () => {
        //  빈 문자로 검색하면 전체 검색, 검색어가 있을 경우 일치하는 것만 반환
        return search === "" ? todo : 
        todo.filter((it) => 
            it.content.toLowerCase().includes(search.toLowerCase())
        );
    }


    return (
        <div className='TodoList'>
            <h4>Todo List 🌱</h4>
            <input className="searchbar" onChange={onChangeSearch} placeholder="검색어를 입력하세요" />
            <div className="list_wrapper">
                {getSearchResult().map((it) => (
                    <TodoItem {...it} key={it.id} onUpdate={onUpdate} onDelete={onDelete}/>
                ))}
            </div>
        </div>
    )
}