import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const [selectData,setSelectData] = useState('');
    const {num} = useParams();
    const navi = useNavigate();
    const PHOTO_URL = process.env.REACT_APP_PHOTO_URL;

    const getSelectData = () => {

    }

    useEffect(() => {
        getSelectData();
    },[]);
    
    return (
        <div>
        {
            sessionStorage.token == null ?
            <div>
                <h3 className='alert alert-danger'>먼저 로그인을 해주세요</h3>
            </div>
            :
            <div>
                <h3 className='alert alert-danger'>게시판 상세보기</h3>
            </div>
        }
        </div>
    );
};

export default BoardDetail;