import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

const FourApp = () => {
    const [count,setCount] = useState(1);//변경 될 떄 마다 렌더링 된다
    const numberRef = useRef(1);//변경이 되어도 렌더링이 발생하지 않는다
    /*
        textarea 처럼 한번에 많은 글자를 입력해야하는 경우
        한글자 입력시마다 렌더링 될 경우 문제가 발생하기도 한다
        그럴 경우에는 ref 변수에 저장 후 나중에 한꺼번에 출력하면 된다
    */

    const countIncreEvent = () => {
        setCount(count + 1);
        console.log("count 변수 값 증가" + count);
    }

    const numberIncreEvent = () => {
        numberRef.current = numberRef.current + 1;
        console.log("numberRef 증가" + numberRef.current);
    }
    return (
        <div>
            <Alert severity='success'>FourApp-state 변수와 ref 변수의 차이점</Alert>

            <Button variant='contained' color='secondary' onClick={countIncreEvent}>count 변수 증가</Button>
            <b style={{fontSize:'3em',marginLeft:'20px'}}>{count}</b>
            <br/><br/>
            <Button variant='contained' color='info' onClick={numberIncreEvent}>numberRef 변수 증가</Button>
            <b style={{fontSize:'3em',marginLeft:'20px'}}>{numberRef.current}</b>
        </div>
    );
};

export default FourApp;