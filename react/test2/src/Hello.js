import React from 'react';
// 구조분해할당
// isSpecial이 true일 경우 * 추가, false일 경우 null
function Hello({ color, name="이름없음", isSpecial }) {
    return <div style={{ color }}>
        {isSpecial ? <b>*</b> : null}
        안녕하세요 {name}
        </div>
}

export default Hello;