import { Alert } from '@mui/material';
import React from 'react';
import "./mystyle.css";

const OneApp = () => {
    let colors = ["red","blue","yellow","orange","white","pink","gold","tomato"];

    let snoopydata = [
        {"photo":"s1.JPG","title":"영123","addr":"서울 강남구"},
        {"photo":"s2.JPG","title":"3213","addr":"서울 강서구"},
        {"photo":"s3.JPG","title":"5212","addr":"서울 강북구"},
        {"photo":"s4.JPG","title":"1934","addr":"서울 강동구"}
    ];
    return (
        <div>
            <Alert severity='success'>OneApp-map 연습</Alert>
            {
                colors.map((color,idx) => 
                <div key={idx} style={{backgroundColor:color}}
                className='box'></div> 
                )
            }
            <br style={{clear:'both'}}/><br/>
            <table className='table table-bordered' style={{width:'400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th>이름</th><th>사진</th><th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        snoopydata.map((data,idx) => 
                        <tr key={idx}>
                            <td>{data.title}</td>
                            <td><img alt='' src={require(`../snoopy/${data.photo}`)}
                            style={{width:'50px'}}/></td>
                            <td>{data.addr}</td>
                        </tr>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;