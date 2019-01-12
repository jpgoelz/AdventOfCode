import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import Select from "@material-ui/core/Select";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";

const styles = theme => ({
  root: {
    display: "inline",
    flexWrap: "wrap"
  },
  formControl: {
    margin: theme.spacing.unit * 3,
    minWidth: 120
  },
  group: {
    margin: `${theme.spacing.unit}px 0`
  },
  selectEmpty: {
    marginTop: theme.spacing.unit
  },
  card: {
    minWidth: 300,
    maxWidth: 300,
    minHeight: 300,
    margin: "auto",
    marginTop: 20
  },
  bullet: {
    display: "inline-block",
    margin: "0 2px",
    transform: "scale(0.8)"
  },
  title: {
    fontSize: 14
  },
  pos: {
    marginBottom: 12
  }
});

class Controller extends Component {
  constructor(props) {
    super(props);
    this.state = {
      part: "",
      result: "",
      value: "",
      day: ""
    };
    this.callController = this.callController.bind(this);
  }

  handleChange = event => {
    this.setState({ value: event.target.value });
  };

  handleSelect = event => {
    this.setState({ [event.target.name]: event.target.value });
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
            style={{ width: "150px" }}
          >
            <MenuItem value="">
              <em>None</em>
            </MenuItem>
            <MenuItem value={1}>December 1st</MenuItem>
            <MenuItem value={2}>December 2nd</MenuItem>
            <MenuItem value={3}>December 3rd</MenuItem>
          </Select>
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
              style={{ width: "120px" }}
            />
            <FormControlLabel
              value="2"
              control={<Radio color="primary" />}
              label="Part 2"
              labelPlacement="start"
              style={{ width: "120px" }}
            />
          </RadioGroup>
        </FormControl>
        <br />
        <Button
          variant="contained"
          color="primary"
          className="ui button"
          onClick={this.callController}
        >
          Go!
        </Button>
        <Card className={classes.card}>
          <CardContent>
            <Typography variant="h5" component="h2">
              Result for Day {this.state.day}
            </Typography>
            <Typography className={classes.pos} color="textSecondary" />
            <Typography component="p">
              <p>{this.state.result}</p>
            </Typography>
          </CardContent>
        </Card>
      </div>
    );
  }

  async callController() {
    const response = await fetch(
      "/api/adventOfCode?day=" + this.state.day + "&part=" + this.state.value
    );
    try {
      const data = await response.json();
      const content = data.content;
      const message = data.message;
      if (response.ok) {
        this.setState({ result: content });
      } else {
        this.setState({ result: message });
      }
    } catch (e) {
      this.setState({ result: "There has been a technical error." });
    }
  }
}

Controller.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(Controller);
