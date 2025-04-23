import { Alert } from '@mui/material';
import React, { useState } from 'react';
import "./mystyle.css";
/*
문제
1. mycarArray 를 해당 자동차 이미지가 나오도록 출력(class 는 mycar 적용)
2. input 에 숫자 1~15 를 입력 후 엔터를 누르면 해당 자동차 번호가 배열에 추가되고
    이미지 형태로 출력이 되도록 한다
    (단 1~15가 아닐 경우 "해당 자동차는 존재하지 않아요" 출력)
3. 해당 자동차를 더블 클릭하면 "해당 자동차를 삭제할까요?" 물어본 후 확인을 클릭하면
    배열에서 삭제하기(filter 이용)

*/
const ThreeApp = () => {
    const [mycarArray,setMycarArray] = useState([1,5,10]);

    const addMycarArray = (e) => {
        if(e.key==='Enter') {   
            const val = Number(e.target.value); 
            if(!val) {
                alert("숫자를 입력해 주세요!");
                e.target.value = "";
                return;
            }

            if (val > 15) {
            alert("해당 자동차는 존재하지 않아요");
            e.target.value = "";
            return;
            } 
            setMycarArray(mycarArray.concat(e.target.value));
            e.target.value="";
        }
    }

    const deleteMycar = (i) => {
        if(window.confirm("해당 자동차를 삭제하시겠습니까 ?")) {
            setMycarArray(mycarArray.filter((mycar,idx) => idx !== i));
        }
    }
    return (
        <div>
            <Alert severity='success'>ThreeApp-배열 문제</Alert>
            <input type='text' className='form-control'
            placeholder='input number' autoFocus
            onKeyUp={addMycarArray}/>
            <br/>
            {
                 mycarArray.map((e,i) =>
                <img key={i} alt='' className='mycar' src={require(`../mycar/mycar${e}.png`)} 
                onDoubleClick={() => deleteMycar(i)}/>)
            }
        </div>
    );
};

export default ThreeApp;