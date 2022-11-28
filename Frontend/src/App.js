import {React} from 'react';
import './App.css';
// import Login from './Components/Login';
import Header from './Components/Header';
import Main from './Components/Main';
import Heading from './Components/Heading';
import NewLogin from './Components/NewLogin';
import DisburseSalary from './Components/DisburseSalary';
function App() {
  window.localStorage.setItem('opnDef',null);
  var reply = JSON.parse(window.localStorage.getItem('loginuser')) 
  console.log("from local storage at app js", reply)

  return (
    <div>
      <Header />
      <Heading/>
      {
        (reply === null) && <NewLogin />
      }
      {
        (reply !== null) && <Main />
      }
      
    </div>
  );


}

export default App;
