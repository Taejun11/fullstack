import React, { useState } from 'react'

export default function Counter() {
    const [ number, setNumber ] = useState(0);
    // useState(0): 기본값 설정
    // 배열반환, number: 현재 상태
    // setNumber: Setter 함수

    const onIncrease = () => {
        // setNumber(number + 1);
        setNumber(prevNumber => prevNumber + 1);
    }
    const onDecrease = () => {
        setNumber(prevNumber => prevNumber - 1);
    }

    return (
        <div>
            <h1>{number}</h1>
            <button onClick={onIncrease}>+1</button>
            <button onClick={onDecrease}>-1</button>
        </div>
    )
}
