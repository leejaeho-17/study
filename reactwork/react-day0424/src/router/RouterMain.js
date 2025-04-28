import React from 'react';
import { Route, Routes } from 'react-router-dom';
import { EightApp, FiveApp, FourApp, OneApp, SevenApp, SixApp, ThreeApp, TwoApp } from '../components';
import Menu from './Menu';


const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path='/' element={<OneApp/>}></Route>
                <Route path='/one' element={<OneApp/>}></Route>
                <Route path='/two' element={<TwoApp/>}></Route>
                <Route path='/three' element={<ThreeApp/>}></Route>
                <Route path='/four' element={<FourApp/>}></Route>
                <Route path='/five/*' element={<FiveApp/>}></Route>
                <Route path='/six' element={<SixApp/>}></Route>
                <Route path='/seven' element={<SevenApp/>}></Route>
                <Route path='/eight' element={<EightApp/>}></Route>
            </Routes>
        </div>
    );
};

export default RouterMain;