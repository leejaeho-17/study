import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';

const MainApp = () => {
    const [idx,setIdx] = useState(3);

    //radio 이벤트
    const selectApp = (e) => {
        setIdx(Number(e.target.value));
        // alert(typeof(e.target.value));
        
    }
    return (
        <div>
            <h3 className='alert alert-danger'>리액트 수업 2025-04-22</h3>
            <label>
                <input type='radio' defaultValue={1} name="selectapp" 
                onClick={selectApp}/>OneApp
            </label>
            <label>
                <input type='radio' defaultValue={2} name="selectapp" 
                onClick={selectApp} />TwoApp
            </label>
            <label>
                <input type='radio' defaultValue={3} name="selectapp"
                onClick={selectApp} defaultChecked/> ThreeApp
            </label>
            <label>
                <input type='radio' defaultValue={4} name="selectapp"
                onClick={selectApp}/>FourApp
            </label>
            <label>
                <input type='radio' defaultValue={5} name="selectapp"
                onClick={selectApp}/>FiveApp
            </label>
            <div style={{marginTop:'20px'}}>
                {idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:
                idx===4?<FourApp/>:<FiveApp/>}
            </div>
        </div>
    );
};

export default MainApp;