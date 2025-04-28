import { Alert, Button } from '@mui/material';
import React from 'react';
import { NavLink, Route, Routes, useNavigate } from 'react-router';
import HomeSub1 from './HomeSub1';
import HomeSub2 from './HomeSub2';
import HomeSub3 from './HomeSub3';

const Home = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success'
            style={{fontSize:'20px'}}>Home 컴포넌트</Alert>

            <button type='button' className='btn btn-sm btn-success'
            onClick={() => navi("/food")}>Food 로 이동</button>
            &nbsp;
            <button type='button' className='btn btn-sm btn-success'
            onClick={() => navi("/food/1")}>Food #2 로 이동</button>
            &nbsp;
            <button type='button' className='btn btn-sm btn-success'
            onClick={() => navi("/food/1/10")}>Food #3 로 이동</button>
            &nbsp;
            <button type='button' className='btn btn-sm btn-success'
            onClick={() => navi("/about")}>About 으로 이동</button>

            
            <div style={{margin:'30px'}}>
                <NavLink to={"/home/sub1"}>경치 1</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub2"}>경치 2</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub3"}>경치 3</NavLink>
            </div>
            <Routes>
                <Route path='sub1' element={<HomeSub1/>}/>
                <Route path='sub2' element={<HomeSub2/>}/>
                <Route path='sub3' element={<HomeSub3/>}/>
            </Routes>
        </div>
    );
};

export default Home;