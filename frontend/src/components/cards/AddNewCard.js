import React, { Component } from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Radio from "@material-ui/core/Radio";
import TextField from "@material-ui/core/TextField";

const styles = theme => ({
  root: {
    display: "inline",
    flexWrap: "wrap"
  },
  formControl: {
    margin: theme.spacing.unit,
    width: 180
  },
  group: {
    margin: `${theme.spacing.unit}px 0`
  },
  title: {
    fontSize: 14
  },
  pos: {
    marginBottom: 12
  },
  radios: {
    marginLeft: 0,
    marginRight: 0,
    marginTop: theme.spacing.unit,
    width: 90
  },
  textField: {
    width: 180,
    marginTop: -10
  }
});

class AddNewCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      part: "",
      result: "",
      value: "",
      day: ""
    };
  }

  handleChange = event => {
    this.setState({ value: event.target.value });
    this.props.callback({ value: event.target.value });
  };

  handleSelect = event => {
    this.setState({ [event.target.name]: event.target.value });
    this.props.callback({ [event.target.name]: event.target.value });
  };

  render() {
    const { classes } = this.props;

    return (
      <div>
        <FormControl
          component="fieldset"
          className={classes.formControl}
          style={{ display: "inline" }}
        >
          <InputLabel htmlFor="day-simple">Day</InputLabel>
          <Select
            value={this.state.day}
            onChange={this.handleSelect}
            displayEmpty
            inputProps={{
              name: "day",
              id: "day-simple"
            }}
            style={{ width: "180px" }}
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            <MenuItem value={1}>December 1st</MenuItem>
            <MenuItem value={2}>December 2nd</MenuItem>
            <MenuItem value={3}>December 3rd</MenuItem>
          </Select>
        </FormControl>
        <FormControl
          component="fieldset"
          className={classes.formControl}
          style={{ display: "inline" }}
        >
          <RadioGroup
            aria-label="part"
            name="part"
            className={classes.group}
            value={this.state.value}
            onChange={this.handleChange}
            style={{ display: "inline" }}
          >
            <FormControlLabel
              value="1"
              control={<Radio color="primary" />}
              label="Part 1"
              labelPlacement="start"
              className={classes.radios}
            />
            <FormControlLabel
              value="2"
              control={<Radio color="primary" />}
              label="Part 2"
              labelPlacement="start"
              className={classes.radios}
            />
          </RadioGroup>
        </FormControl>
        <FormControl
          component="fieldset"
          className={classes.formControl}
          style={{ display: "inline" }}
        >
          <TextField
            id="standard-dense"
            label="Paste your puzzle input"
            className={classes.textField}
            margin="dense"
          />
        </FormControl>
      </div>
    );
  }
}

AddNewCard.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(AddNewCard);
