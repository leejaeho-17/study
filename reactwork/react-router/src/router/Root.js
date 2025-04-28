import React from 'react';
import { BrowserRouter } from 'react-router';
import RouterMain from './RouterMain';

const Root = () => {
    return (
        <BrowserRouter>
            <RouterMain/>
        </BrowserRouter>
    );
};

export default Root;