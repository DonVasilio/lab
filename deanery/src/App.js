import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import { Navbar, Nav, Dropdown, Tabs, Table, Tab } from "react-bootstrap";
import {Component} from "react";
import Request from "./Services/Request"
import 'color'

class App extends Component {
  constructor() {
    super();
    this.state = {
      activeGroup: 1,
      students: null,
      subjectType:null,
      wholeJournal:null
    };
  }

  componentDidMount() {
    Request.getStudentsOnGroup(this.state.activeGroup).then((students) => {
      this.setState({students: students});
    });
    Request.getTypeAndGroup().then((subjectType) => {
      this.setState({subjectType: subjectType});
    });
    Request.getWholeJournal().then((wholeJournal) => {
      this.setState({wholeJournal: wholeJournal});
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

          {this.state.subjectType ? <JournalForTypeAndSubject
              subjectType={this.state.subjectType}/> : null}

          {this.state.wholeJournal ? <WholeJournal
              wholeJournal={this.state.wholeJournal}/> : null}

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

class JournalForTypeAndSubject extends Component {
  render() {
    return <Table bordered>
      <thead>
      <tr>
        <th>Предмет</th>
        <th>Тип</th>
      </tr>
      </thead>
      <tbody>
      {this.props.subjectType.map((subjectType) => {
        return <tr>
          <td>{subjectType.subject}</td>
          <td>{subjectType.type}</td>
        </tr>
      })}
      </tbody>
    </Table>
  }
}

class WholeJournal extends Component {
  render() {
    return <Table bordered>
      <thead>
      <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Группа</th>
        <th>Количество пересдач</th>
        <th>Оценка</th>
        <th>Предмет</th>
        <th>Тип зачета</th>
      </tr>
      </thead>
      <tbody>
      {this.props.wholeJournal.map((wholeJournal) => {
        return <tr>
          <td>{wholeJournal.SURNAME}</td>
          <td>{wholeJournal.NAME}</td>
          <td>{wholeJournal.SECOND_NAME}</td>
          <td>{wholeJournal.GR}</td>
          <td>{wholeJournal.COUNT}</td>
          <td style={{color: wholeJournal.MARK!="Неудовлетворительно" ? "black" : "red"}}>{wholeJournal.MARK}</td>
          <td>{wholeJournal.SUBJECT}</td>
          <td>{wholeJournal.TYPE}</td>
        </tr>
      })}
      </tbody>
    </Table>
  }
}

export default App;
