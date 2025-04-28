import { Alert } from '@mui/material';
import React from 'react';
import SevenSmartHome from './SevenSmartHome';

const SevenApp = () => {
    return (
        <div>
            <Alert severity='success'>SevenApp-useCallback</Alert>

            <div style={{position:'absolute',top:'50%',left:'50%'}}>
                <SevenSmartHome/>
            </div>
        </div>
    );
};

export default SevenApp;