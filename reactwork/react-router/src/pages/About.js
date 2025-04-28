import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router';

const About = () => {
    const {emp} = useParams();
    console.log(emp);
    return (
        <div>
            <Alert severity='success'
            style={{fontSize:'20px'}}>About 컴포넌트</Alert>

            {
                emp == null?
                <div>
                    <h1>저는 취업준비생 입니다</h1>
                </div>
                :
                <div>
                    <h1>저는 {emp} 에 다니고 있습니다</h1>
                </div>
            }
        </div>
    );
};

export default About;