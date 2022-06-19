import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import HeaderComponent from "./components/HeaderComponent";
import AddEmployeeComponent from "./components/AddEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Route exact path="/" component={AddEmployeeComponent}></Route>
        </div>
      </Router>
    </div>
  );
}

export default App;
