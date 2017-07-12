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

  _tableTitle() {
    return (
      <div style={{  textAlign: 'center' }}>
        <span style={{ fontSize: 20 }}>测试导入导出功能</span>
        <span style={{ float: 'right' }}>
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

  _export() {
    Modal.confirm({
      title: '确定要导出吗',
      onOk() {
        document.getElementById("formExcel").submit();
        // location.href = '/poi-learn/export';
      },
      onCancel() {},
    });
  }

  render() {
    const { year, data } = this.state;

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
        <form id="formExcel" action="../export" method="post" style={{ display: 'none'}}>
          <input type="text" name="year" value={year} />
          <input type="text" name="data" value={JSON.stringify(data)} />
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
