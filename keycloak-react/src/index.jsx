import React from 'react';
import { render } from 'react-dom';
import DemoComponent from './components/DemoComponent';
import LoginComponent from './components/LoginComponent';

const Login = () => <LoginComponent />;

render(<Login />, document.getElementById('app'));
