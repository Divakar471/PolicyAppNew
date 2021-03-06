import React, {useContext, useEffect} from 'react';
import './App.css';
import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import NavigationBar from './components/NavigationBar';
import HomePage from './components/HomePage';
import Footer from './components/Footer';
import LoginPage from "./components/LoginPage";
import SignupPage from "./components/SignupPage";
import Profile from "./components/Profile";
import Logout from "./components/Logout";
import ListCustomerComponent from './components/ListCustomerComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateCustomerComponent from './components/CreateCustomerComponent';
import UpdateCustomerComponent from './components/UpdateCustomerComponent';
import ViewCustomerComponent from './components/ViewCustomerComponent';

import {LoginContext, UserContext} from "./Store";



const App = () => {

    const [isLoggedIn, setIsLoggedIn] = useContext(LoginContext);
    const [user, setUser] = useContext(UserContext);


    // Check if there is an any session on the start.
    useEffect(() => {
        if(localStorage.getItem("session")){
            console.log("There is a session!");
            setIsLoggedIn(true);
            setUser(localStorage.getItem("session"));
        } else {
            console.log("There is not a session.");
        }

    }, []);

    // Check when isLoggedIn changes.
    useEffect(() => {
        if(isLoggedIn){
            localStorage.clear();
            localStorage.setItem("session", user);
            console.warn("User--> " + user);
        }

        if (!isLoggedIn){
            localStorage.clear();
            console.warn("isLoggedIn: False");
        }

    }, [isLoggedIn]);

    return (
        <Router>
            <NavigationBar/>
            <HeaderComponent />
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop: "20px"}}>
                        <Switch>
                            <Route path="/" exact component={HomePage} />
                            <Route path="/login" exact component={LoginPage} />
                            <Route path="/signup" exact component={SignupPage} />
                            <Route path="/profile" exact component={Profile} />
                            <Route path="/logout" exact component={Logout} />
                            <Route path = "/employees" component = {ListCustomerComponent}></Route>
                          <Route path = "/add-employee/:id" component = {CreateCustomerComponent}></Route>
                          <Route path = "/view-employee/:id" component = {ViewCustomerComponent}></Route>
                           <Route path = "/update-employee/:id" component = {UpdateCustomerComponent}></Route> 
                        </Switch>
                    </Col>
                </Row>
            </Container>
            
            <Footer />

        </Router>
    )

}

export default App;
