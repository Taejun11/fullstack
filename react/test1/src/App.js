// import logo from './logo.svg';
// import './App.css';

import Button from "./Button";
import Hello from "./hello";
import Wrapper from "./Wrapper";

function App() {
    const handleClick = () => {
        alert("버튼이 클릭되었습니다.");
    }

    return (
        <Wrapper>
            <Hello name="react" color="red" />
            <Hello color="pink" />
            <Button onClick={handleClick} text={"버튼"}></Button>
        </Wrapper>
    );
}

export default App;
