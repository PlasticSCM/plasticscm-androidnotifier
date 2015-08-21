import os

class PlasticEnviron(object):
    # The user who started the operation in the client
    __user = 'PLASTIC_USER'
    # The client machine that started the operation
    __client_machine = 'PLASTIC_CLIENTMACHINE'
    # The hostname of the Plastic Server
    __server = 'PLASTIC_SERVER'

    # The comment given by the user at branch creation
    # The comment given by the user at label creation
    # The comment given by the user on the checkin operation
    __comment = 'PLASTIC_COMMENT'

    # The branch that is being created
    __branch_name = 'PLASTIC_BRANCH_NAME'

    # The full branch name that is breing created
    __full_branch_name = 'PLASTIC_FULL_BRANCH_NAME'

    # The repository that is being created
    # The repository that is being deleted
    # The repository name where the branch is being created
    # The repository name where the label is being created
    # The repository name where the attribute is being created
    # The repository name where the code review is created
    # The repository name where the code review is edited
    __repository_name = 'PLASTIC_REPOSITORY_NAME'

    # The repository id that is being deleted
    __repository_id = 'PLASTIC_REPOSITORY_ID'

    # The label that is being created
    __label_name = 'PLASTIC_LABEL_NAME'

    # The attribute that is being created
    __attribute_name = 'PLASTIC_ATTRIBUTE_NAME'

    # The name given to the new workspace
    # The name of the workspace which selector is being set
    __workspace_name = 'PLASTIC_WORKSPACE_NAME'

    # The path of the workspace on the client machine
    # The client path of the workspace which selector is being set
    __workspace_path = 'PLASTIC_WORKSPACE_PATH'

    # The client of the workspace that is being updated
    __update_path = 'PLASTIC_WORKSPACE_PATH'

    # The title given to the code review
    # The title given to the edited code review
    __review_title = 'PLASTIC_REVIEW_TITLE'

    # The plastic review status
    __review_status = 'PLASTIVC_REVIEW_STATUS'

    # The username of the user asigned to the code review, if any
    __review_asignee = 'PLASTIC_REVIEW_ASIGNEE'

    # The specification of the object of which the code review has been created
    __review_target = 'PLASTIC_REVIEW_TARGET'

    # The type of the review target
    __review_target_type = 'PALSTIC_REVIEW_TARGET_TYPE'

    __variables = [
        __user,
        __client_machine,
        __server,
        __comment,
        __branch_name,
        __full_branch_name,
        __repository_name,
        __repository_id,
        __label_name,
        __attribute_name,
        __workspace_name,
        __workspace_path,
        __update_path,
        __review_title,
        __review_status,
        __review_asignee,
        __review_target,
        __review_target_type
    ]

    __codenames = [
        '%{USER}',
        '%{CLIENTMACHINE}',
        '%{SERVER}',
        '%{COMMENT}',
        '%{BRANCH}',
        '%{FULLBRANCH}',
        '%{REPNAME}',
        '%{REPID}',
        '%{LABEL}',
        '%{ATTR}',
        '%{WKSPACENAME}',
        '%{WKSPACEPATH}',
        '%{UPDATEPATH}',
        '%{REVIEWTITLE}',
        '%{REVIEWSTATUS}',
        '%{REVIEWASGINEE}',
        '%{REVIEWTARGET}',
        '%{REVIEWTARGETTYPE}',
    ]

    def __init__(self):
        self.environ_vars = {}
        for env_name, code_name in zip(PlasticEnviron.__variables, PlasticEnviron.__codenames):
            self.environ_vars[code_name] = os.getenv(env_name, 'EMPTY')

    def replace(self, word):
        return self.environ_vars.get(word, word)

