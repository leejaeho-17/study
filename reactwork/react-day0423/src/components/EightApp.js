import { Alert } from '@mui/material';
import React, { useState } from 'react';
import SubEightApp from './SubEightApp';
/*
부모, 자식간의 통신

1. 부모 컴포넌트에서 자식 컴포넌트로 props 를 통해서 값이나 이벤트 전달을 할 수 있다

2. 자식 컴포넌트에서는 부모 컴포넌트의 값을 props 로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다

3. 만약 변경하려면 부모의 이벤트를 props 를 통해서 호출을 해서 그 이벤트 함수에서 변결해야 한다
 */
const EightApp = () => {
    const [count,setCount] = useState(10);

    const increCountEvent = () => {
        setCount(count + 1);
    }

    const decreCountEvent = (num) => {
        setCount(count - num);
    }
    return (
        <div>
            <Alert severity='success'>EightApp-부모 자식 컴포넌트 간 통신</Alert>
            <hr/>
                <h2>총 방문 횟수는 {count} 회 입니다</h2>
            <hr/>
            <SubEightApp name={'이영자'} age={33} countHandler={increCountEvent} decreCount={decreCountEvent}/>
            <SubEightApp name={'1234'} age={22} countHandler={increCountEvent} decreCount={decreCountEvent}/>
            <SubEightApp name={'2345'} age={11} countHandler={increCountEvent} decreCount={decreCountEvent}/>
        </div>
    );
};

export default EightApp;