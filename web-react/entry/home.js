import {render} from 'react-dom';
import React, { Component } from 'react';

import { Button, Table, Modal } from 'antd';

import * as api from '../redux/services/api';

class Index extends Component {

  constructor(props) {
    super(props);
    this.state = {
      year: 2016,
      data: [
        {
          key: '1',
          name: '胡彦斌',
          age: 32,
          address: '西湖区湖底公园1号'
        }, {
          key: '2',
          name: '吴彦祖',
          age: 42,
          address: '西湖区湖底公园2号'
        }
      ],
    }
  }

  componentDidMount() {

  }

  _tableTitle() {
    return (
      <div style={{  textAlign: 'center' }}>
        <span style={{ fontSize: 20 }}>测试导入导出功能</span>
        <span style={{ float: 'right' }}>
          {/* <Button
            size="large"
            type="primary"
            style={{ marginRight: 10 }}
            onClick={() => this._import()}>
            导入
          </Button> */}
          <Button
            size="large"
            type="primary"
            onClick={() => this._export()}>
            导出
          </Button>
        </span>
      </div>
    )
  }

  _import() {
    Modal.confirm({
      title: '确定要导入吗',
      onOk() {},
      onCancel() {},
    });
  }

  _export() {
    const { year, data } = this.state;
    Modal.confirm({
      title: '确定要导出吗',
      onOk() {
        api.post('/export', {
          year: year,
          data: JSON.stringify(data),
        });
        // location.href = '/poi-learn/export';
      },
      onCancel() {},
    });
  }

  render() {
    const { data } = this.state;

    const columns = [
      {
        title: '姓名',
        dataIndex: 'name',
        key: 'name',
      }, {
        title: '年龄',
        dataIndex: 'age',
        key: 'age',
      }, {
        title: '住址',
        dataIndex: 'address',
        key: 'address',
      }
    ];

    return (
      <div>
        <form action="../export" method="post">
          <p>year: <input type="text" name="year" value={2016} /></p>
          <p>data: <input type="text" name="data" value={JSON.stringify(data)} /></p>
          <input type="submit" value="Submit" />
        </form>
        <div style={{ padding: '20px 50px', minWidth: 800 }}>
          <Table
            bordered
            columns={columns}
            dataSource={data}
            title={() => this._tableTitle()}
          />
        </div>
      </div>
    );
  }
}

render(<Index />, document.getElementById('react-content'));
