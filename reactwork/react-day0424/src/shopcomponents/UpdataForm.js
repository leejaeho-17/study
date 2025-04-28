import { InputTwoTone } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import React, { useEffect, useState } from 'react';
import noimage from '../image/noimage.png';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
    const [shopData, setShopData] = useState('');
    const {num} = useParams();

    //업로드한 사진을 저장하기 위한 변수
    const [photo,setPhoto] = useState(null);
    const navi = useNavigate();
    
    //사진 출력할 url
    const photourl = process.env.REACT_APP_PHOTO_URL;

    const addurl="/react/addshop";//package.json 에서 proxy 설정을 한경우
    
    //처음 시작시 스프링으로부터 데이터 가져오기
    const getSelectData = () => {
        let url = "/react/detail?num="+num;
        axios.get(url)
        .then(res => {
            setShopData(res.data);
            setPhoto(res.data.photo);
        });
    }

    useEffect(() => {
        getSelectData();
    },[]);//처음 시작 시 한번만 호출

    //입력 시 호출
    const shopDataChange = (e) => {
        const {name,value} = e.target;
        setShopData({
            ...shopData,
            [name]:value
        })
    }

    //submit 발생 시 호출
    const onSubmit = (e) => {
        e.preventDefault();//기본 이벤트를 무효화(action 호출)

        //수정
        axios.post("/react/shopupdate",shopData)
        .then(res => {
            //수정 성공 후 상세보기 페이지로 이동
            navi(`/five/detail/${num}`);
        })
    }
    //파일 업로드 이벤트
    const photoUploadEvent = (e) => {
        const imageFile = new FormData();
        const uplaodFile = e.target.files[0];
        imageFile.append("upload",uplaodFile);

        axios({
            method:'post',
            url:'/react/upload',
            data:imageFile
        }).then(res => setPhoto(res.data));
    }

    return (
        <div>
            <Alert severity='success'>UpdateForm</Alert>
            <form onSubmit={onSubmit}>
            <div className='form-control'>
            <input type='text' className='form-control' placeholder='상품명'
            value={shopData.sangpum}  name="sangpum" onChange={shopDataChange}/>
            <input type='file' className='form-control' onChange={photoUploadEvent}/>
            <img alt='' src={photourl+photo} style={{width:'120px'}}/>
            <input type='color' className='form-control'
            value={shopData.color} name="color" onChange={shopDataChange}/>
            <input type='text' className='form-control' name="price"
            value={shopData.price} onChange={shopDataChange}/> 
            <input type='date' className='form-control'
            value={shopData.sangguip} name="sangguip" onChange={shopDataChange}/>
             
            <Button color='success' variant='contained' type='submit'
            style={{margin:'10px 160px'}}>상품 수정</Button>
            </div>
            </form>
        </div>
    );
};

export default UpdateForm;