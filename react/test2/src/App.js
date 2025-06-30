import React from 'react';
import Hello from './Hello';
import Wrapper from './Wrapper';

function App() {
    return (
        <Wrapper>
            <Hello name="react" color="red" isSpecial/>
            {/* isSpecial 이름만 넣을 경우 기본적으로 isSpecial={true} 로 인식 */}
            <Hello color="pink" />
        </Wrapper>
    );
}

export default App;