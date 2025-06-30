import React, { useState } from 'react'

export default function InputSample() {
    const [text, setText] = useState('');
    const onChange = (e) => {
        setText(e.target.value);
    }
    // (e): 이벤트 객체
    // e.target: 이벤트가 발생한 html 요소
    // e.target.value: 이벤트가 발생한 요소의 현재 값
    const onReset = () => {
        setText('');
    }

    return (
        <div>
            <input onChange={onChange} value={text}/>
            {/* onChange={onChange}: 사용자가 값을 입력하면 text의 값이 즉시 바뀜 */}
            {/* value={text}: input 값은 항상 text의 값으로 즉시 바뀜 */}
            <button onClick={onReset}>초기화</button>
            <div>
                <b>값: {text}</b>
            </div>
        </div>
    )
}
