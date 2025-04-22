import React, { useState } from 'react';
import photo1 from '../image2/1.jpg'
import photo2 from '../image2/2.jpg'
import photo3 from '../image2/3.jpg'
import photo4 from '../image2/4.jpg'
import photo5 from '../image2/5.jpg'

const ThreeApp = () => {
    const [show,setShow]=useState(false);
    const [write,setWrite] = useState();
    const [image,setImage] = useState(photo2);
    const [imageSize,setImageSize] = useState(100);
    const [borderStyle,setBorderStyle] = useState('solid');
    const [borderWidth,setBorderWidth] = useState(10);

    const checkShow = (e) => {
        setShow(e.target.checked);
    }

    //점점작게 버튼 이벤트
    const smallImage=()=>{
        setImageSize(imageSize-10);
    }

    //점점크게 버튼 이벤트
    const largeImage=()=>{
        setImageSize(imageSize+10);
    }
    return (
        <div>
            <h3 className='alert alert-success'>ThreeApp</h3>
            <h1 style={{fontFamily:'gothic',color:'pink'}}>오늘의 문제</h1>
            <hr/>
            <input type='checkbox' onClick={checkShow}/>&nbsp;사진숨김
            <button style={{color:'red',border:'1px solid red',backgroundColor:'white', height:'40px', marginLeft:'50px'}}
            onClick={smallImage}>점점 작게</button>&nbsp;&nbsp;
            <button style={{color:'red',border:'1px solid red',backgroundColor:'white', height:'40px'}}
            onClick={largeImage}>점점 크게</button>
            <br/><br/>
            <input type='text' placeholder='내용 입력하세요' style={{width:'400px'}} onChange={(e) => setWrite(e.target.value)}/>
            <br/>
            {
                !show &&
                <img alt='' src={image} style={{width:`${imageSize}px`,border:`${borderWidth}px ${borderStyle}`}}/>
            }
            <br/><br/>
            <select style={{width:'200px',height:'30px'}} onChange={(e) => setImage(e.target.value)}>
                <option value={photo1}>1</option>
                <option value={photo2}>2</option>
                <option value={photo3}>3</option>
                <option value={photo4}>4</option>
                <option value={photo5}>5</option>
            </select>
          
            <br/><br/>
            <select className='form-select' style={{width:'200px'}}
                    onChange={
                        (e)=>{
                            setBorderStyle(e.target.value);
                        }
                    }>
                    <option>solid</option>
                    <option selected>inset</option>
                    <option>double</option>
                    <option>groove</option> 
                    <option>dotted</option> 
                    <option>dashed</option>                    
                </select>
            <h1 className='alert alert-info'>{write}</h1>
        </div>
    );
};

export default ThreeApp;