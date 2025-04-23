import { Alert, Button } from '@mui/material';
import React from 'react';

const FiveApp = () => {
    return (
        <div>
            <Alert severity='success'>FiveApp-useRef 응용</Alert>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                    <tr>
                        <th className='table-success' width="100">이름</th>
                        <td>
                            <input type='text' className='form-control'/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">자바점수</th>
                        <td>
                            <input type='text' className='form-control'/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">리액트점수</th>
                        <td>
                            <input type='text' className='form-control'/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='outlined' color='warning'>결과보기</Button>
                        </td>
                    </tr>
                </tbody>

            </table>
        </div>
    );
};

export default FiveApp;