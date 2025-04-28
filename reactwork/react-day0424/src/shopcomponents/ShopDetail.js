import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import noimage from '../image/noimage.png';

const ShopDetail = () => {
    const photourl = process.env.REACT_APP_PHOTO_URL;

    const [selectData,setSelectData] = useState('');
    
    const {num} = useParams();

    const navi = useNavigate();

    //num 에 해당하는 데이터 가져오기
    const getSelectData = () => {
        let geturl = "/react/detail?num="+num;
        axios.get(geturl)
        .then(res => setSelectData(res.data));
    }
    const deleteShopData = (num) => {
        let deleteurl = "/react/shopdelete?num="+num;
        axios.delete(deleteurl)
        .then(res => navi('/five/list'));
    }

    //처음 로딩 시 함수 호출
    useEffect(() => getSelectData(),[]);
    return (
        <div>
            <Alert severity='success'>상품 상세보기</Alert>
            {
                selectData &&
                <h2><b>{selectData.sangpum}</b></h2>
            }
                <div>
                    <img alt='' src={selectData.photo?photourl+selectData.photo:noimage}
                    style={{width:'100px',height:'100px'}}/>
                </div>
                <h2><b>{selectData.price}</b></h2>
                <h2 style={{backgroundColor:selectData.color}}>{selectData.color}</h2>
                <h2><b>{selectData.sangguip}</b></h2>
                <h2><b>{selectData.writeday}</b></h2>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={() => navi('/five/form')}>상품추가</button>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={() => navi('/five/list')}>상품목록</button>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={() => navi(`/five/updataform/${num}`)}>상품수정</button>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={() => deleteShopData(num)}>상품삭제</button>
        </div>
    );
};

export default ShopDetail;