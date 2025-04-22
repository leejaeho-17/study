import { DeleteForever, DeleteSweepOutlined, HeartBrokenSharp } from '@mui/icons-material';
import React from 'react';
import styled from 'styled-components';

const FourApp = () => {
    const Title = styled.h2`
        color:orange;
        font-size:1.5em;
        background-color:yellow;
        width:300px;
        text-align:center;
        box-shadow: 1px 1px 1px gray;
    `;
    const MyButton = styled.button`
        color:blue;
        background-color:yellow;
        border: 5px inset green;
        width:130px;
    `;

    const Tomatobutton = styled(MyButton)`
        color:tomato;
        border-color:tomato;
    `;
    return (
        <div>
            <h3 className='alert alert-success'>FourApp-styled로 디자인 변경하기</h3>
            <Title>Hello React</Title>
            <Title>안녕하세요</Title>
            <button>기본 버튼 모양</button>
            <br/>
            <MyButton type='button'>MyButton 모양</MyButton>
            <br/>
            <Tomatobutton>토마토버튼</Tomatobutton>
            <h5>Material Icons</h5>
            <DeleteForever/>
            <HeartBrokenSharp/>
            <DeleteSweepOutlined/>
        </div>
    );
};

export default FourApp;