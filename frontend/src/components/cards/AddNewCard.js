import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import FloatingActionButtons from "../buttons/FloatingActionButtons";
import CardTemplate from "./CardTemplate";

const styles = {
  card: {
    minWidth: 300,
    maxWidth: 300,
    minHeight: 300,
    margin: 10,
    position: "relative"
  },
  actions: {
    position: "absolute",
    bottom: 0
  },
  title: {
    fontSize: 14
  },
  pos: {
    marginBottom: 12
  }
};

function AddNewCard(props) {
  const { classes } = props;

  return (
    <div>
      <Typography className={classes.title} color="textSecondary" gutterBottom>
        New Card
      </Typography>
      <Typography component="p">New Card</Typography>
    </div>
  );
}

AddNewCard.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(AddNewCard);
