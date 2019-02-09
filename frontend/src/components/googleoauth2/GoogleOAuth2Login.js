import React from "react";
import GoogleLogin from "react-google-login";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core";

const responseGoogle = response => {
  console.log(response);
};
const styles = theme => {};

class GoogleOAuth2Login extends React.Component {
  render() {
    return (
      <GoogleLogin
        clientId="709257205913-fv6nv6cjaot6ot927q75lpt5g0r5s8t5.apps.googleusercontent.com"
        buttonText="Login"
        onSuccess={responseGoogle}
        onFailure={responseGoogle}
      />
    );
  }
}
GoogleOAuth2Login.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(GoogleOAuth2Login);
