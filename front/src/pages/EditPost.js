import React from 'react';
import styled from 'styled-components';
import TextEditor from '../components/TextEditor';
import HowToEdit from '../components/editPost/HowToEdit';
import PostEditInfo from '../components/editPost/PostEditInfo';

const EditPostPage = styled.div`
  display: flex;
  width: 1100px;
  padding: 24px;
  justify-content: space-between;
`;

const EditInputArea = styled.div`
  margin-bottom: 15px;
  > p {
    font-size: 15px;
    color: #0c0d0e;
    margin: 0px 0px 4px;
    padding: 0px 2px;
  }
  > input {
    width: 662px;
    height: 32.59px;
    padding: 7.8px 9.1px;
    border-radius: 3px;
    border: 1px solid #bcbbbb;
    margin-bottom: 15px;
    :focus {
      border: 1px solid #b3d3ea;
      outline: 2px solid #d0e3f1;
    }
  }
`;

const EditButtonArea = styled.div`
  margin: 12px 0px 16px;
  font-size: 13px;
  .save {
    width: 85.14px;
    height: 37.8px;
    background-color: #0a95ff;
    border: none;
    border-radius: 5px;
    margin-right: 8px;
    padding: 10.4px;
    color: #fff;
    :hover {
      background-color: #3172c6;
    }
  }
  .cancel {
    width: 64.4px;
    height: 37.8px;
    padding: 10.4px;
    background-color: #fff;
    border: none;
    border-radius: 5px;
    color: #3172c6;
    :hover {
      background-color: #f1f8fe;
    }
  }
`;

function EditPost() {
  return (
    <EditPostPage>
      <div className="left">
        <PostEditInfo />
        <EditInputArea>
          <p>Title</p>
          <input type="text" />
          <p>Body</p>
          <TextEditor />
        </EditInputArea>
        <EditInputArea>
          <p>Edit Summary</p>
          <input type="text" />
        </EditInputArea>
        <EditButtonArea>
          <button className="save" type="button">
            Save edits
          </button>
          <button className="cancel" type="button">
            Cancel
          </button>
        </EditButtonArea>
      </div>
      <div>
        <HowToEdit />
      </div>
    </EditPostPage>
  );
}

export default EditPost;
