import { InputTwoTone } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';
import noimage from '../image/noimage.png';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ShopForm = () => {
    const [sangpum,setSangpum]=useState('');
    const [color,setColor]=useState('#ccffcc');
    const [price,setPrice]=useState(0);
    const [sangguip,setSangguip]=useState('2025-01-01');
    const [photo,setPhoto] = useState('');
    const navi = useNavigate();
    
    const photourl = process.env.REACT_APP_PHOTO_URL;

    const addurl="/react/addshop";//package.json 에서 proxy 설정을 한경우

    const addShopEvent = (shopdata) => {
        axios.post(addurl,shopdata)
        .then(res => {
            navi('/five/list');
        })
    }
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
            <Alert severity='success'>ShopForm</Alert>
            <div className='form-control'>
            <input type='text' className='form-control' placeholder='상품명'
            value={sangpum} onChange={(e) => setSangpum(e.target.value)}/>
            <input type='file' className='form-control' onChange={photoUploadEvent}/>
            <img alt='' src={photourl+photo} style={{width:'120px'}}/>
            <input type='color' className='form-control'
            value={color} onChange={(e)=>setColor(e.target.value)}/>
            <input type='text' className='form-control'
            value={price} onChange={(e)=>setPrice(e.target.value)}/> 
            <input type='date' className='form-control'
            value={sangguip} onChange={(e)=>setSangguip(e.target.value)}/>
             
            <Button color='success' variant='contained'
            style={{margin:'10px 160px'}} 
            onClick={() => addShopEvent({sangpum, color, price, sangguip, photo})}>추가</Button>
            </div>
        </div>
    );
};

export default ShopForm;