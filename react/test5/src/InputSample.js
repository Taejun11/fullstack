import React, { useRef, useState } from 'react'

export default function InputSample() {
    const [input, setInput] = useState({ //useState: 변경되는 값을 관리
        name:'', nickname:''
    });
    const nameInput = useRef();

    const {name, nickname} = input; //비구조화 할당
    // input.name input.nickname 대신 name, nickname으로 가져옴

    const onChange = (e) =>{
        const {value, name} = e.target; //e.target에서 name, value 추출
        setInput({
            ...input, //기존의 input 객체 복사
            [name] : value //name 키를 가진 값을 value로 설정
        });
    };
    const onReset = () =>{
        setInput({
            name:'', nickname:''
        });
        nameInput.current.focus();
    };

    return (
        <div>
            <input name='name' ref={nameInput} placeholder="이름" onChange={onChange} value={name}></input>
            <input name='nickname' placeholder="닉네임" onChange={onChange} value={nickname}></input>
            <button onClick={onReset}>초기화</button>
            <div>
                <b>값: </b>
                {name}({nickname})
            </div>
        </div>
    )
}
