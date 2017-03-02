import Keycloak from "./keycloak";
import config from "./keycloak.json";
import React from "react";
import $ from 'jquery'

var LoginComponent = React.createClass({
  getInitialState: function () {
    var that =this;

    let states = {profile:{}};
    var keycloakInitConfig = {};
    keycloakInitConfig.url = config['auth-server-url'];
    keycloakInitConfig.realm = config['realm'];
    keycloakInitConfig.clientId = config['resource'];
    keycloakInitConfig.secret = (config['credentials'] || {})['secret'];

    let _keycloak = states.keycloak = Keycloak(keycloakInitConfig);

    _keycloak.init({
      onLoad: 'login-required'
    })
      .success((authenticated) => {
        if (authenticated) {
          states.keycloak.
          states.keycloak.loadUserProfile().success(function (profile) {
            var newState = Object.assign({},that.state);
            newState.profile = profile;
            that.setState(newState);
            console.log(profile);
          });
        }
        else {
          window.location.reload();
        }
      })
      .error(function () {
        window.location.reload();
      });
    return states;
  },
  logout: function () {
    this.state.keycloak.logout();
  },
  render: function () {
    return (
      <div>

        <div>
          <h5>You're logged in as:</h5>

          Id: {this.state.profile.id}
          <p/>
          Username: {this.state.profile.username}
          <p/>
          Email: {this.state.profile.email}
          <p/>
          Full Name: {this.state.profile.firstName} {this.state.profile.lastName}
          <p/>

          <button name="Logout" onClick={this.logout}>Logout</button>
        </div>
      </div>
    );
  }
});

export default LoginComponent;
