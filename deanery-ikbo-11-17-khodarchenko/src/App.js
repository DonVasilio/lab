import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import { Navbar, Nav, Dropdown, Tabs, Table, Tab } from "react-bootstrap";
import {Component} from "react";

class App extends Component {
  constructor() {
    super();
    this.state = {
      activeGroup: 0
    };
  }

  render() {
    const students = [
      [
        {name: 'Иванов Иван Иванович', markPrIS: 5, markSII: 4},
        {name: 'Петров Пётр Петрович', markPrIS: 3, markSII: 2}
      ],
      [
        {name: 'Валиева Лидия Павловна', markPrIS: 3, markSII: 5},
        {name: 'Илюшин Игорь Витальевич', markPrIS: 5, markSII: 5}
      ],
      [
        {name: 'Голутвин Семён Юрьевич', markPrIS: 4, markSII: 2},
        {name: 'Сёмина Анна Николаевна', markPrIS: 3, markSII: 5}]
    ];

    return (
        <div className="App">
          <JournalTable students={students[this.state.activeGroup]}/>
          <button onClick={() => {
            this.setState({activeGroup: 0});
          }}>Группа 1</button>
          <button onClick={() => {
            this.setState({activeGroup: 1});
          }}>Группа 2</button>
          <button onClick={() => {
            this.setState({activeGroup: 2});
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
        <th>ФИО</th>
        <th>ПрИС</th>
        <th>СИИ</th>
      </tr>
      </thead>
      <tbody>
      {this.props.students.map((student, index) => {
        return <tr>
          <td>{index + 1}</td>
          <td>{student.name}</td>
          <td>{student.markPrIS}</td><td>{student.markSII}</td>
        </tr>
      })}
      </tbody>
    </Table>
  }
}

export default App;
