import React from "react";
import GoogleLogout from "react-google-login";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core";

const logout = response => {
  console.log(response);
}

const styles = theme => {};

class GoogleOAuth2Logout extends React.Component {
  render() {
    return <GoogleLogout buttonText="Logout" onLogoutSuccess={logout} />;
  }
}
GoogleOAuth2Logout.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(GoogleOAuth2Logout);
