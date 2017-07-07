import {render} from 'react-dom';
import React, { Component } from 'react';

import { Button } from 'antd';

class Index extends Component {
  render() {
    return (
      <Button>
        zz
      </Button>
    );
  }
}

render(<Index />, document.getElementById('react-content'));
