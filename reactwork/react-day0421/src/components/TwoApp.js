//rsf 단축키
// import React from 'react';

// function TwoApp(props) {
//     return (
//         <div>
            
//         </div>
//     );
// }

// export default TwoApp;  

//rsc 단춬키
import React from 'react';
import "./mystyle.css";
import food1 from "../food/11.jpg";
import food2 from "../food/8.jpg";
const TwoApp = () => {
    let msg = "have a nice day!!!";//출력은 가능하지만 태그 내에서 수정은 불가능하다
    return (
        <div>
            <h2>TwoApp 컴포넌트</h2>
            <img alt="" src={food1} className='photo1'/>
            <img alt="" src={food2} className='photo2'/>
            {/* h5의 배경색, 글자색, 넓이, 글꼴 모두 변경하기 */}
            <h5 style={{backgroundColor:'yellow',color:'blue',width:'200px',fontFamily:'gothic'}}>{msg}</h5>
        </div>
    );
};

export default TwoApp;