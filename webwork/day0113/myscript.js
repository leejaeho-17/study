window.onload = function () {
    let mycar = document.querySelectorAll(".mycar");//배열타입


     // b[0].onmouseover = function() {
        //     this.style.color = "gray";
        // }
        // b[0].onmouseout = function() {
        //     this.style.color = "red";
        // }


    //0번이미지 이벤트
    //마우스를 올리면 ../photo/k-052.png 로 변경하고 벗어나면 다시 원래 이미지로
    let Photo = "";
    mycar[0].onmouseover = function () {
        Photo = this.getAttribute("src");
        this.setAttribute = ("src","../photo/k-051.png");
    }
    mycar[0].onmouseout = function () {
        this.setAttribute("src",Photo);
    }
    //1번 이미지 이벤트 
    //마우스를 올리면 border 를 알아서 설정하고 벗어나면 없애기
    mycar[1].onmouseover = function () {
        this.style.borderStyle = "inset";
        this.style.borderWidth = "10px";
        this.style.borderColor = "green";
    }
    mycar[1].onmouseout = function () {
        this.style.border = "none";
    }
    //2번 이미지 이벤트
    //마우스를 올리면 .happy 를 적용하고 벗어나면 다시 없애기
    //.happy 는 미리 만들어둘것(내용 상관없음)
    mycar[2].onmouseover = function () {
        this.setAttribute("class","mycar happy");
    }
    mycar[2].onmouseout = function () {
        this.setAttribute("class","mycar");
    }
}