import { Alert } from '@mui/material';
import React from 'react';

const EightApp = () => {
    const names = ['이효라','1234','123451','123412','123412','123412'];

    //방법 1
    const nameList = names.map((irum,idx) => <h5 key={idx}>{idx}:{irum}</h5>);

    return (
        <div>
            <h3 className='alert alert-success'>EightApp-map 반복문</h3>
            <h5>배열 변수 없이 1 부터 10까지 반복하기</h5>
            {
                [...new Array(10)].map((_,idx) => <b key={idx}>{idx+1}</b>)
            }
            <hr/>
            <h5>mycar 폴더에 mycar 이미지를 넣고 mycar 1부터 15번까지 이미지 출력하기</h5>
            {
                [...new Array(15)].map((_,idx) => <img key={idx} alt='' src={require(`../mycar/mycar${idx+1}.png`)} 
                style={{width:'100px',height:'100px',margin:'5px', border:'3px solid black'}}/>)
            }
            <hr/>
            {nameList}

            {/* 배열 반복문을 직접 넣는 방법 */}
            {
                names.map((irum,idx) => <Alert key={idx} severity='secondary'>{idx}:{irum}
                <img alt='' src={require(`../image/${idx+1}.jpg`)} style={{width:'100px'}}/>
                </Alert>)
            }

            
            
        </div>
    );
};

export default EightApp;