import React from "react";
import AddNewCard from "./AddNewCard";
import { shallow } from "enzyme";
import chai from "chai";
import spies from "chai-spies";

chai.use(spies);
const expect = chai.expect;

describe("AddNewCard", () => {
  it("should call handleSelect upon picking a day", () => {
    let mockCallback = chai.spy();
    const component = shallow(<AddNewCard callback={mockCallback} />).dive();
    console.log(
      component
        .childAt(0)
        .childAt(1)
        .name()
    );
    component
      .find("WithStyles(WithFormControlContext(Select))")
      .simulate("change", { target: { value: 1 } });
    expect(mockCallback).to.have.been.called();
  });
});
