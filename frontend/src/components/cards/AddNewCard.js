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
      day: "",
      daysImplemented: []
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

  componentDidMount() {
    this.callController();
  }

  renderMenuItems() {
    let decemberDays = this.addDecemberDays();
    const menuItems = [];
    for (let day of this.state.daysImplemented) {
      menuItems.push(<MenuItem value={day}>{decemberDays[day]}</MenuItem>);
    }
    return menuItems;
  }

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
            {this.renderMenuItems()}
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

  async callController() {
    const response = await fetch("/api/adventOfCode/daysimplemented");
    try {
      const data = await response.json();
      const content = data._embedded.integerList.sort();
      const message = data.message;
      if (response.ok) {
        console.log(content);
        this.setState({
          daysImplemented: content
        });
      } else {
        this.setState({ daysImplemented: message });
      }
    } catch (e) {
      this.setState({ daysImplemented: "There has been a technical error." });
    }
  }

  addDecemberDays() {
    let decemberDays = {};
    decemberDays[1] = "December 1st";
    decemberDays[2] = "December 2nd";
    decemberDays[3] = "December 3rd";
    decemberDays[4] = "December 4th";
    decemberDays[5] = "December 5th";
    decemberDays[6] = "December 6th";
    decemberDays[7] = "December 7th";
    decemberDays[8] = "December 8th";
    decemberDays[9] = "December 9th";
    decemberDays[10] = "December 10th";
    decemberDays[11] = "December 11th";
    decemberDays[12] = "December 12th";
    decemberDays[13] = "December 13th";
    decemberDays[14] = "December 14th";
    decemberDays[15] = "December 15th";
    decemberDays[16] = "December 16th";
    decemberDays[17] = "December 17th";
    decemberDays[18] = "December 18th";
    decemberDays[19] = "December 19th";
    decemberDays[20] = "December 20th";
    decemberDays[21] = "December 21th";
    decemberDays[22] = "December 22th";
    decemberDays[23] = "December 23th";
    decemberDays[24] = "December 24th";
    return decemberDays;
  }
}

AddNewCard.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(AddNewCard);
