import { Alert } from '@mui/material';
import React from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import { ShopDetail, ShopForm, ShopList, UpdataForm} from '../shopcomponents';

const FiveApp = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success'>FiveApp-shop 라우터 설정</Alert>
            <div style={{margin:'20px'}}>
                <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={() => navi("/five/list")}>Shop목록</button>
                &nbsp;&nbsp;
                <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={() => navi("/five/form")}>Shop추가</button>
                <br/><br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='list' element={<ShopList/>}/>
                    <Route path='form' element={<ShopForm/>}/>
                    <Route path='detail/:num' element={<ShopDetail/>}/>
                    <Route path='updataform/:num' element={<UpdataForm/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;