import { OneApp } from "./OneApp";
import ThreeApp from "./ThreeApp";
import TwoApp from "./TwoApp";

const MainApp=()=> {
    return (
        <div>
            <h3 className="alert alert-danger">MainApp</h3>
            <OneApp/>
            <hr/>
            <TwoApp/>
            <hr/>
            <ThreeApp/>
        </div>
    )
}
export default MainApp;