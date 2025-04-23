import { Alert } from '@mui/material';
import React, { useState } from 'react';

const SevenApp = () => {
    const [starArray,setStarArray] = useState([
        {
            starName:'김우빈1',
            starAge:'22',
            starPhoto:'2.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-0000-0000'
        },
        {
            starName:'김우빈2',
            starAge:'23',
            starPhoto:'3.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-0000-0000'
        },
        {
            starName:'김우빈3',
            starAge:'24',
            starPhoto:'4.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-0000-0000'
        },
        {
            starName:'김우빈4',
            starAge:'25',
            starPhoto:'5.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-0000-0000'
        },
        {
            starName:'김우빈5',
            starAge:'26',
            starPhoto:'1.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-0000-0000'
        },

    ]);
    return (
        <div>
            <Alert severity='success'>SevenApp-배열 데이터 출력</Alert>
            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                    {
                        starArray.map((row,idx) => 
                            <>
                            <tr>
                                <td rowSpan={4}>
                                    <img alt='' src={require(`../star/${row.starPhoto}`)}
                                    style={{width:'200px',height:'230px'}}/>
                                </td>
                                <td>이름 : {row.starName}</td>
                            </tr>
                            <tr>
                                <td>나이 : {row.starAge}</td>
                            </tr>
                            <tr>
                                <td>핸드폰 : {row.starPhone}</td>
                            </tr>
                            <tr>
                                <td>주소 : {row.starAddress}</td>
                            </tr>
                            </>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;