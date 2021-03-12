import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import { Navbar, Nav, Dropdown, Tabs, Table, Tab } from "react-bootstrap";
import {Component} from "react";
import Request from "./Services/Request"

class App extends Component {
  constructor() {
    super();
    this.state = {
      activeGroup: 1,
      students: null
    };
  }

  componentDidMount() {
    Request.getStudentsOnGroup(this.state.activeGroup).then((students) => {
      this.setState({students: students});
    });
  }

  render() {
    return (
        <div className="App">
          {this.state.students ? <JournalTable
              students={this.state.students}/> : null}
          <button onClick={() => {
            Request.getStudentsOnGroup(1).then((students) => {
              this.setState({students: students});
              this.setState({activeGroup: 1});
            });
          }}>Группа 1</button>
          <button onClick={() => {
            Request.getStudentsOnGroup(2).then((students) => {
              this.setState({students: students});
              this.setState({activeGroup: 2});
            });
          }}>Группа 2</button>
          <button onClick={() => {
            Request.getStudentsOnGroup(3).then((students) => {
              this.setState({students: students});
              this.setState({activeGroup: 3});
            });
          }}>Группа 3</button>
        </div>
    );
  }
}

class JournalTable extends Component {
  render() {
    return <Table bordered>
      <thead>
      <tr>
        <th>#</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Группа</th>
      </tr>
      </thead>
      <tbody>
      {this.props.students.map((student) => {
        return <tr>
          <td>{student.id}</td>
          <td>{student.name}</td>
          <td>{student.surname}</td>
          <td>{student.second_name}</td>
          <td>{student.study_group_id}</td>
        </tr>
      })}
      </tbody>
    </Table>
  }
}

export default App;
